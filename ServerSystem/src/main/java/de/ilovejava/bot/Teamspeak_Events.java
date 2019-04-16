package de.ilovejava.bot;

import com.github.theholywaffle.teamspeak3.api.event.ChannelCreateEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelDeletedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelDescriptionEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelMovedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelPasswordChangedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientJoinEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientLeaveEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientMovedEvent;
import com.github.theholywaffle.teamspeak3.api.event.PrivilegeKeyUsedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ServerEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.TS3Listener;
import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;

import de.ilovejava.utils.Utils;

public class Teamspeak_Events {
	public Teamspeak_Events() {
		Utils.getApi().registerAllEvents();
		Utils.getApi().addTS3Listeners(new TS3Listener() {
			
			@Override
			public void onTextMessage(TextMessageEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onServerEdit(ServerEditedEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPrivilegeKeyUsed(PrivilegeKeyUsedEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onClientMoved(ClientMovedEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onClientLeave(ClientLeaveEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onClientJoin(ClientJoinEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onChannelPasswordChanged(ChannelPasswordChangedEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onChannelMoved(ChannelMovedEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onChannelEdit(ChannelEditedEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onChannelDescriptionChanged(ChannelDescriptionEditedEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onChannelDeleted(ChannelDeletedEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onChannelCreate(ChannelCreateEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
