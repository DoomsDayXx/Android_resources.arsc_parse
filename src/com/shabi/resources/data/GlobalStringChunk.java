package com.shabi.resources.data;

import com.shabi.resources.Utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class GlobalStringChunk extends BaseHeader {

    public int mStrCount, mStyleCount, mFlag, mStrStartOffset, mStyleStartOffset;
    public List<String> mStrs;

    public GlobalStringChunk(byte[] data) {
        super(data);
    }

    @Override
    protected void parse() {
        mStrs = new ArrayList<>();
        mStrCount = Utils.bytes2Int(Utils.copy(mData, mOffset, 4));
        mStyleCount = Utils.bytes2Int(Utils.copy(mData, mOffset += 4, 4));
        mFlag = Utils.bytes2Int(Utils.copy(mData, mOffset += 4, 4));
        mStrStartOffset = Utils.bytes2Int(Utils.copy(mData, mOffset += 4, 4));
        mStyleStartOffset = Utils.bytes2Int(Utils.copy(mData, mOffset += 4, 4));

        mOffset += 4;
        mStrs.clear();
        for (int index = 0; index < mStrCount; index++) {
            int ofset = Utils.bytes2Int(Utils.copy(mData, mOffset + index * 4, 4)) + mStrStartOffset;
            int size = Utils.copy(mData, ofset, 1)[0];
            byte[] data = Utils.copy(mData, ofset += 2, size);
            mStrs.add(new String(data));
        }
    }
}
