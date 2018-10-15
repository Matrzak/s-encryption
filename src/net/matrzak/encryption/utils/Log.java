package net.matrzak.encryption.utils;

import java.util.logging.Level;
import java.util.logging.Logger;



public class Log {
	
	public enum LogType{
		
		INFO(Level.INFO),
		WARNING(Level.WARNING),
		ERROR(Level.SEVERE);
		
		private final Level l;
		LogType(Level level){
			this.l = level;
		}
		public Level getLevel() {
			return this.l;
		}
	}
	
	public Log(LogType type, String message) {
		Logger.getGlobal().log(type.getLevel(), message);
	}
	public Log(String message) {
		System.out.println(message);
	}

}
