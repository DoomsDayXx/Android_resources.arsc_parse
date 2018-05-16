package com.shabi.resources.data;

import com.wjdiankong.parseresource.Utils;

public class TypeSpaceChunk extends BaseHeader {
    public TypeSpaceChunk(byte[] data) {
        super(data);
    }

    @Override
    protected void parse() {
        if (mType!=ChunkType.RES_TABLE_TYPE_SPEC_TYPE) return;
        int typeId = Utils.copyByte(mData, mOffset, 1)[0];
        int res0 = Utils.copyByte(mData, mOffset += 1, 1)[0];
        int res1 = Utils.byte2Short(Utils.copyByte(mData, mOffset += 1, 2));
        int spaceCount = Utils.byte2int(Utils.copyByte(mData, mOffset += 2, 4));

        mOffset += 4;
        System.out.println(spaceCount);
        for (int index = 0; index < spaceCount; index++) {
            //System.out.println(Integer.toHexString(Utils.byte2int(Utils.copyByte(mData, mOffset + index * 4, 4))));
        }
    }
}
