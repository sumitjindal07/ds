package com.sj.pattern.command.remote;

import com.sj.pattern.command.ICommand;
import com.sj.pattern.command.impl.CeilingFanCommandImpl;
import com.sj.pattern.command.impl.LightCommandImpl;
import com.sj.pattern.command.impl.MusicCommandImpl;
import com.sj.pattern.command.impl.NoCommand;
import com.sj.pattern.command.vendors.CeilingFan;
import com.sj.pattern.command.vendors.Light;
import com.sj.pattern.command.vendors.Music;

public class RemoteLoader {
	
	private int slotSize;
	private int currentSlotNumber;
	private RemoteControl remote;
	
	public RemoteLoader (int slotSize) {
		this.slotSize = slotSize;
		remote = new RemoteControl(slotSize);
		initRemote();
	}
	
	private void initRemote() {
		for(int i=1; i<=slotSize; i++) {
			remote.setSlot(i, new NoCommand());
		}
		this.currentSlotNumber = 0;
	}
	
	public RemoteControl getRemoteControl() {
		return remote;
	}
	
	private boolean addSlot(ICommand command) {
		if(currentSlotNumber>=slotSize) {
			System.out.println("All slots are full");
			return false;
		}
		remote.setSlot(currentSlotNumber+1, command);
		currentSlotNumber++;
		System.out.println("Added "+command.toStringSimple()+" at slot number "+currentSlotNumber);
		return true;
	}
	
	public boolean addMusicSlot(Music music) {
		return addSlot(new MusicCommandImpl(music));
	}
	
	public boolean addLightSlot(Light light) {
		return addSlot(new LightCommandImpl(light));
	}
	
	public boolean addCeilingFanSlot(CeilingFan fan) {
		return addSlot(new CeilingFanCommandImpl(fan));
	}
	
	public void resetRemote() {
		initRemote();
	}
}
