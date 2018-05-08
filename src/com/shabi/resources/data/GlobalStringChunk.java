package com.shabi.resources.data;

import com.shabi.resources.Utils;

import java.util.ArrayList;
import java.util.List;

public class GlobalStringChunk extends BaseHeader {

    public int mStrCount, mStyleCount, mFlag, mStrStartOffset, mStyleStartOffset;
    public List<String> mStringPool;

    public GlobalStringChunk(byte[] data) {
        super(data);
    }

    @Override
    protected void parse() {
        mStringPool = new ArrayList<>();
        mStrCount = Utils.bytes2Int(Utils.copy(mData, mOffset, 4));
        mStyleCount = Utils.bytes2Int(Utils.copy(mData, mOffset += 4, 4));
        mFlag = Utils.bytes2Int(Utils.copy(mData, mOffset += 4, 4));
        mStrStartOffset = Utils.bytes2Int(Utils.copy(mData, mOffset += 4, 4));
        mStyleStartOffset = Utils.bytes2Int(Utils.copy(mData, mOffset += 4, 4));

        mOffset += 4;
        mStringPool.clear();
        for (int index = 0; index < mStrCount; index++) {
            int ofset = Utils.bytes2Int(Utils.copy(mData, mOffset + index * 4, 4)) + mStrStartOffset;
            int size = Utils.copy(mData, ofset, 2)[1] & 0x7f;
            byte[] data = Utils.copy(mData, ofset + 2, size);
            mStringPool.add(new String(data));
        }
        mOffset += mStrCount * 4;
        System.out.println(mOffset);
        for (int index = 0; index < mStyleCount; index++) {
            int ofset = Utils.bytes2Int(Utils.copy(mData, mOffset + index * 4, 4)) + mStyleStartOffset;
           // System.out.println(Integer.toHexString(ofset + 12));
        }
    }
}