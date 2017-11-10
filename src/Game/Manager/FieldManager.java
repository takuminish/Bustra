package Game.Manager;

import Game.Field;
public class FieldManager {

	private Field field; 
	
	public FieldManager(Field field) {
		
		this.field = field;
	
	}
	
	public void ChangeText(String str) {
		this.field.TextChange(str);
	}
}
