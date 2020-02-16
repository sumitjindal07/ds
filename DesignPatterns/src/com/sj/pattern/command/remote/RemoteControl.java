package com.sj.pattern.command.remote;

import java.util.Arrays;
import java.util.stream.IntStream;

import com.sj.pattern.command.ICommand;

/**
 * 
 * @author sumit
 *	This remote control has n slots and each slot has one ON and other OFF button
 *	This also has one UNDO button, one RESET button
 */
public class RemoteControl {
	
	private int slotSize;
	private Slot[] slots;
	private Slot currentSlot;
	
	public RemoteControl(int slotSize) {
		this.slotSize = slotSize;
		slots = new Slot[slotSize];
		currentSlot = null;
	}
	
	protected void setSlot(int slotIndex, ICommand command) {
		if(slotIndex>slotSize || slotIndex<=0 || command==null)
			throw new IllegalArgumentException("Please pass slot number between 1 to "+slotSize);
		
		slots[slotIndex-1] = new Slot(command);
	}
	
	public void actionForSlotON(int slotIndex) {
		if(slotIndex>slotSize || slotIndex<=0)
			throw new IllegalArgumentException("Please pass slot number between 1 to "+slotSize);
		
		slots[slotIndex-1].onButtonPressed();
	}
	
	public void actionForSlotOFF(int slotIndex) {
		if(slotIndex>slotSize || slotIndex<=0)
			throw new IllegalArgumentException("Please pass slot number between 1 to "+slotSize);
		
		slots[slotIndex-1].offButtonPressed();
	}
	
	public void actionForUndo() {
		if(currentSlot!=null)
			currentSlot.undoForButtonPressed();
	}
	
	public void actionForReset() {
		Arrays.asList(slots).forEach(slot->slot.resetSlot());
		currentSlot = null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Remote details: "+slotSize+" slots and a reset and an undo button!!");
		sb.append("\npress slot number followed by n for ON button and f for OFF button!!\n");
		IntStream.range(0, slotSize).
			mapToObj(i -> String.format("%d. %s\n", (i+1), slots[i].toString())).
			forEach(sb::append);
		
		sb.append(String.format("%d. Undo\n%d. Reset\n", slotSize+1, slotSize+2));
		
		return sb.toString();
	}
	
	private class Slot {
		private ICommand command;

		public Slot(ICommand command) {
			this.command = command;
		}
		
		public void resetSlot() {
			while(command.executeOff());
		}

		public void onButtonPressed() {
			if(command.executeOn())
				currentSlot = this;
		}
		
		public void offButtonPressed() {
			if(command.executeOff())
				currentSlot = this;
		}
		
		//Though Undo button is not at slot level, 
		//here undo means to undo the button pressed for this slot
		public void undoForButtonPressed() {
			if(command.undo())
				currentSlot = null;
		}
		
		@Override
		public String toString() {
			return command.toString();
		}
	}
}
