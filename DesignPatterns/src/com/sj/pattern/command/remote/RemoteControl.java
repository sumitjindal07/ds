package com.sj.pattern.command.remote;

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
	
	public void setSlot(int slotIndex, ICommand command) {
		if(slotIndex>slotSize || slotIndex<=0 || command==null)
			throw new IllegalArgumentException("Please pass slot number between 1 to "+slotSize);
		
		slots[slotIndex] = new Slot(command);
	}
	
	public void actionForSlotON(int slotIndex) {
		if(slotIndex>slotSize || slotIndex<=0)
			throw new IllegalArgumentException("Please pass slot number between 1 to "+slotSize);
		
		slots[slotIndex].onButtonPressed();
				
	}
	
	public void actionForSlotOFF(int slotIndex) {
		if(slotIndex>slotSize || slotIndex<=0)
			throw new IllegalArgumentException("Please pass slot number between 1 to "+slotSize);
		
		slots[slotIndex].offButtonPressed();
	}
	
	public void actionForUndo() {
		if(currentSlot!=null)
			currentSlot.undoForButtonPressed();
	}
	
	public void actionForReset() {
		
	}
	
	private class Slot {
		private ICommand command;

		public Slot(ICommand command) {
			this.command = command;
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
	}
}
