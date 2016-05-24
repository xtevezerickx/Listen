package br.com.listen.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.fileupload.InvalidFileNameException;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	
	@RequestMapping("uploadImagem")
	public String formUpload(int cdId,Model model){
		model.addAttribute("cdId",cdId);
		System.out.println("passou por aqui? cdid"+cdId);
		return "cd/uploadImagem";
	}

	@RequestMapping("upload")
		public String handleFormUpload(@RequestParam("file") MultipartFile file,int cdId) throws IOException{
		System.out.println("O id do Cd e:"+cdId);	
		
		if(!file.isEmpty()){
				BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
				String local="C:\\Users\\Erick Maia\\git\\Listen2\\Listen\\WebContent\\imagens\\CD"+cdId+".png";
				File destination = new File(local);
				ImageIO.write(src, "PNG", destination);	
		}

			return "redirect:listarCd";
		}
	
	
}
