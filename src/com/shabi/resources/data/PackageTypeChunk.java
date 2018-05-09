package com.shabi.resources.data;

import com.shabi.resources.Utils;

public class PackageTypeChunk extends BaseHeader {

    public int mPackageId;
    public String mPackageName;
    public int mTypeStringsPool;
    public int mLastPublicType;
    public int mKeyStringsPool;
    public int mLastPublicKey;

    public PackageTypeChunk(byte[] data) {
        super(data);
    }

    @Override
    protected void parse() {
        if (mType != ChunkType.RES_TABLE_PACKAGE_TYPE) {
            return;
        }

        mPackageId = Utils.bytes2Int(Utils.copy(mData, mOffset, 4));
        mPackageName = new String(Utils.copy(mData, mOffset += 4, 256));
        mTypeStringsPool = Utils.bytes2Int(Utils.copy(mData, mOffset += 256, 4));
        mLastPublicType = Utils.bytes2Int(Utils.copy(mData, mOffset += 4, 4));
        mKeyStringsPool = Utils.bytes2Int(Utils.copy(mData, mOffset += 4, 4));
        mLastPublicKey = Utils.bytes2Int(Utils.copy(mData, mOffset += 4, 4));

    }
}
