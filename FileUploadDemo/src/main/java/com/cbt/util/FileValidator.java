package com.cbt.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cbt.model.FileBucket;

@Component
public class FileValidator implements Validator {
    
   public boolean supports(Class<?> clazz) {
       return FileBucket.class.isAssignableFrom(clazz);
   }

   public void validate(Object obj, Errors errors) {
       FileBucket file = (FileBucket) obj;
        
       if(file.getFile()!=null){
           if (file.getFile().getSize() == 0) {
               errors.rejectValue("file", "missing.file");
           }
       }
       
       if(file.getFileSize() !=0){
    	   long size = file.getFileSize()/1024;
    	   if(size> 5120){
    		   errors.rejectValue("file1", "missing.file");
    	   }
       }
   }
}