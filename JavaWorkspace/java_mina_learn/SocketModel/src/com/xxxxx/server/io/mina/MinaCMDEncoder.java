/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xxxxx.server.io.mina;

import java.nio.ByteBuffer;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.springframework.util.SystemPropertyUtils;

import com.hq.datapool.DyncDataPool;
import com.hq.packet.Request_Login;
import com.hq.packet.Response_Login;

/**
 *
 * @author Administrator
 */
public class MinaCMDEncoder implements ProtocolEncoder
{
	@Override
	public void encode(IoSession is, Object o, ProtocolEncoderOutput peo) throws Exception
	{
		System.out.println("����");
		
		byte[] b = (byte[])o;	
		int size = b.length;	
		IoBuffer buffer = IoBuffer.allocate(size+4);//�õ���mina��ioBuffer
		buffer.putInt(size);//��Ϣ������
		buffer.put(b);//��Ϣ�������ֽ�����
		buffer.flip();// ��limit��Ϊ��ǰposition����position��Ϊ0
		peo.write(buffer);
	}

	@Override
	public void dispose(IoSession is) throws Exception
	{
	}

}
