package com.shabi.resources.data;

import com.shabi.resources.Utils;

import java.util.ArrayList;
import java.util.List;

public class PackageChunk extends BaseHeader {


    public int mPackageId;
    public String mPackageName;
    public int mTypeStringsPoolOffset;
    public int mLastPublicType;
    public int mKeyStringsPoolOffset;
    public int mLastPublicKey;
    public List<String> mTypeStringPool, mKeyStringPool;
    private ArrayList<TypeSpaceChunk> typeSpaceChunks;

    public PackageChunk(byte[] data) {
        super(data);
    }

    @Override
    protected void parse() {
        if (mType != ChunkType.RES_TABLE_PACKAGE_TYPE) {
            return;
        }

        mPackageId = Utils.bytes2Int(Utils.copy(mData, mOffset, 4));
        mPackageName = new String(Utils.copy(mData, mOffset += 4, 256));
        mTypeStringsPoolOffset = Utils.bytes2Int(Utils.copy(mData, mOffset += 256, 4));
        mLastPublicType = Utils.bytes2Int(Utils.copy(mData, mOffset += 4, 4));
        mKeyStringsPoolOffset = Utils.bytes2Int(Utils.copy(mData, mOffset += 4, 4));
        mLastPublicKey = Utils.bytes2Int(Utils.copy(mData, mOffset += 4, 4));
        GlobalStringChunk typeStrChunk = new GlobalStringChunk(Utils.copy(mData, mTypeStringsPoolOffset, mData.length - mTypeStringsPoolOffset));
        mTypeStringPool = typeStrChunk.mStringPool;
        GlobalStringChunk keyStrChunk = new GlobalStringChunk(Utils.copy(mData, mKeyStringsPoolOffset, mData.length - mKeyStringsPoolOffset));
        mKeyStringPool = keyStrChunk.mStringPool;

        mOffset = mKeyStringsPoolOffset + keyStrChunk.mChunkSize;
        typeSpaceChunks = new ArrayList<>();
        while (true) {
            byte[] data = Utils.copy(mData, mOffset, mData.length - mOffset);
            if (data==null||data.length<1) break;
            if (Utils.getChunkType(data)!=ChunkType.RES_TABLE_TYPE_SPEC_TYPE) break;
            TypeSpaceChunk chunk = new TypeSpaceChunk(Utils.copy(mData, mOffset, mData.length - mOffset));
            typeSpaceChunks.add(chunk);
            mOffset += chunk.mChunkSize;
        }

        new ResTabTypeChunk(Utils.copy(mData, mOffset, mData.length - mOffset));

    }
}
