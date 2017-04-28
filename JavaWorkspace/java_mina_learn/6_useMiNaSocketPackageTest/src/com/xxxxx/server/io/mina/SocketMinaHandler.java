/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xxxxx.server.io.mina;

import com.xxxxx.server.client.Client;
import com.xxxxx.server.client.session.MinaSession;
import com.xxxxx.server.io.ServerHandler;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 *
 * @author Administrator
 */
public class SocketMinaHandler extends IoHandlerAdapter {

    private ServerHandler handler = new ServerHandler();

    @Override
    public void messageSent(IoSession session, Object message) 
    {
        System.out.println("messageSent");
        Client client = (Client) session.getAttribute(Client.class.getSimpleName());
        handler.messageSent(client.getSession(), message);//ת�����Լ�������ܿ�����
    }

    @Override
    public void messageReceived(IoSession session, Object message) 
    {
    	System.out.println("messageReceived");
        Client client = (Client) session.getAttribute(Client.class.getSimpleName());
        handler.messageReceived(client.getSession(), message);
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause)
    {
    	System.out.println("exceptionCaught");
        Client client = (Client) session.getAttribute(Client.class.getSimpleName());
        cause.printStackTrace();
        handler.exceptionCaught(client.getSession(), cause);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) 
    {
    	System.out.println("sessionIdle");
    }

    @Override
    public void sessionClosed(IoSession session) 
    {
    	System.out.println("sessionClosed");
        Client client = (Client) session.getAttribute(Client.class.getSimpleName());
        handler.sessionClosed(client.getSession());
    }

    @Override
    public void sessionOpened(IoSession session)
    {
    	System.out.println("sessionOpened");
        MinaSession ms = new MinaSession(session);
        Client client = new Client();
        client.setSession(ms);
        ms.setAttribute(client);
        handler.sessionOpened(client.getSession());
    }

    @Override
    public void sessionCreated(IoSession session) 
    {
    	System.out.println("sessionCreated");
    }
}
