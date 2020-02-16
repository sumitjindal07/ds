package com.sj.pattern.command;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.sj.pattern.command.remote.RemoteControl;
import com.sj.pattern.command.remote.RemoteLoader;
import com.sj.pattern.command.vendors.CeilingFan;
import com.sj.pattern.command.vendors.Light;
import com.sj.pattern.command.vendors.Music;

public class RemoteControlClient {
	
	private static RemoteControl createLoadedRemote(int slotSize) {
		Music music = new Music();
		CeilingFan fan = new CeilingFan();
		CeilingFan fan2 = new CeilingFan();
		Light roomLight = new Light("Room");
		Light kitchenLight = new Light("Kitchen");
		
		RemoteLoader rl = new RemoteLoader(slotSize);
		rl.addLightSlot(roomLight);
		rl.addCeilingFanSlot(fan);
		rl.addLightSlot(kitchenLight);
		rl.addCeilingFanSlot(fan2);
		rl.addMusicSlot(music);
		
		return rl.getRemoteControl();
	}

	public static void main(String[] args) throws Exception {
		
		int slotSize = 7;
		RemoteControl remote = createLoadedRemote(slotSize);
		System.out.println(remote.toString());
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String button;
		
		while(!(button=reader.readLine().trim().toLowerCase()).equalsIgnoreCase("exit"))
		{
			try {
				
				if(button.length()>2)
					System.out.println("wrong key:"+button+", try again!!");
			
				int buttonNumber = Integer.valueOf(""+button.charAt(0));
				
				if(buttonNumber==slotSize+1)
					remote.actionForUndo();
				else if(buttonNumber==slotSize+2)
					remote.actionForReset();
				else
				{
					if(button.length()==1)
					{
						System.out.println("wrong key:"+button+", press n for ON and f for volume!!");
						continue;
					}
					char onoff = button.charAt(1);
					switch(onoff) {
						case 'n': //ON
							remote.actionForSlotON(buttonNumber);
							break;
						case 'f': //OFF
							remote.actionForSlotOFF(buttonNumber);
							break;
						default:
							System.out.println("wrong key:"+button+", press n for ON and f for volume!!");
					}
				}
			}catch(Exception e) {
				System.out.println("wrong key:"+button+", "+e.getMessage()+"!!");
			} finally {
			}
		}//end of while
	}
}
