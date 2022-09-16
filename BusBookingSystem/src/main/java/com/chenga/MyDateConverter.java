package com.chenga;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;


@Provider
public class MyDateConverter  implements ParamConverterProvider {

	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {

		if(rawType.getName().equals(MyDate.class.getName())) {
			return new ParamConverter<T>() {

				@Override
				public T fromString(String value) {
					Calendar requestDate=Calendar.getInstance();
					
					if("tomorrow".equalsIgnoreCase(value)) {
						requestDate.add(Calendar.DATE, 1);
					}
					else if("yesterday".equalsIgnoreCase(value)) {
						requestDate.add(Calendar.DATE, -1);
					}
					
					MyDate mydate=new MyDate();
					mydate.setDate(requestDate.get(Calendar.DATE));
					mydate.setMonth(requestDate.get(Calendar.MONTH));
					mydate.setYear(requestDate.get(Calendar.YEAR));
					
					return rawType.cast(mydate);
				}

				@Override
				public String toString(T value) {
					
					if(value==null) {
						return null;
					}
					return value.toString();
				}
				
			};
		}
		
		return null;
	}

}
