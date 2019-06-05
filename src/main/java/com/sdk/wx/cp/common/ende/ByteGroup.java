package com.sdk.wx.cp.common.ende;

import java.util.ArrayList;

/**
 * 企业微信官方加密包中的工具（字节拼接器）
 * @author yangtao
 * @date 2019/05/29
 */
class ByteGroup {
	ArrayList<Byte> byteContainer = new ArrayList<Byte>();

	public byte[] toBytes() {
		byte[] bytes = new byte[byteContainer.size()];
		for (int i = 0; i < byteContainer.size(); i++) {
			bytes[i] = byteContainer.get(i);
		}
		return bytes;
	}

	public ByteGroup addBytes(byte[] bytes) {
		for (byte b : bytes) {
			byteContainer.add(b);
		}
		return this;
	}

	public int size() {
		return byteContainer.size();
	}
}
