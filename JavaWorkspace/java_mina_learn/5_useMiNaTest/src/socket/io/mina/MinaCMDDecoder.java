/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket.io.mina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

/**
 *���������⿪��Ϣ�ĸ�ʽ����ɿ��Դ�������ݸ�ʽ��
 */
public class MinaCMDDecoder extends CumulativeProtocolDecoder {

    /**
     * 
     * @return true ������ɣ��ͷŻ��棬false ����δ��ɣ��ȴ���һ�ν��롣
     * @throws Exception 
     */
    @Override
    protected boolean doDecode(IoSession is, IoBuffer ib, ProtocolDecoderOutput pdo) throws Exception {
        System.out.println("����");
        return false;
    }
}
