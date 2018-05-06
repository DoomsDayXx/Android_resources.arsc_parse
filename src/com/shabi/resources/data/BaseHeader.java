package com.shabi.resources.data;

import com.shabi.resources.Utils;

public abstract class BaseHeader {
    short mType, mHeadSize;
    int mChunkSize;
    byte[] mData;
    int mOffset;

    public BaseHeader(byte[] data) {

        if (data == null || data.length < 6) return;

        mType = Utils.byte2Short(Utils.copy(data, mOffset, 2));
        mHeadSize = Utils.byte2Short(Utils.copy(data, mOffset += 2, 2));
        mChunkSize = Utils.byte2Short(Utils.copy(data, mOffset += 2, 4));

        if (mType == 0x2) {
            mData = Utils.copy(data, 0, mOffset + 4);
        } else {
            mData = Utils.copy(data, 0, mChunkSize);
        }
        parse();
    }

    protected abstract void parse();

}
