package com.ikubinfo.clothingStore.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class ErrorFormat {
	private String message;
	private Date timeStamp=new Date(); 
	private String path;
	private String suggestion;
	

}
