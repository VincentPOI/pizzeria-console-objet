package fr.pizzeria.utils;

import java.lang.reflect.Field;
import fr.pizzeria.utils.ToString;

public class StringUtils {
	public static String getStringValue(Object o){
				
		String chaine = "";
		
		try{
			Field[] fields = o.getClass().getDeclaredFields();
			for(Field f : fields){
				f.setAccessible(true);
				
				if (f.isAnnotationPresent(ToString.class)){
					ToString annotation = f.getAnnotation(ToString.class);
					Object value = f.get(o);
					if (annotation.uppercase()){
						chaine += value.toString().toUpperCase();
					}else{
						chaine +=value.toString();
					}
					chaine += annotation.separateur();		
				}
			}
			return chaine;
		}catch(Exception e){
			return null;
		}	
	}	
}
