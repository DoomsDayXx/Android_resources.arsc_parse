package com.shabi.resources.data;

import com.shabi.resources.Utils;

public abstract class BaseHeader {
    public short mType, mHeadSize;
    public int mChunkSize;
    public byte[] mData;
    public int mOffset;

    public BaseHeader(byte[] data) {

        if (data == null || data.length < 6) return;

        mType = Utils.byte2Short(Utils.copy(data, mOffset, 2));
        mHeadSize = Utils.byte2Short(Utils.copy(data, mOffset += 2, 2));
        mChunkSize = Utils.bytes2Int(Utils.copy(data, mOffset += 2, 4));
        mOffset += 4;
        if (mType == 0x2) {
            mChunkSize = mOffset+4;
            mData = Utils.copy(data, 0, mOffset + 4);
        } else {
            mData = Utils.copy(data, 0, mChunkSize);
        }
        parse();
    }

    protected abstract void parse();

}
