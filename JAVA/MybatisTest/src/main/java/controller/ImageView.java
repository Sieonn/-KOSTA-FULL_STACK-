package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ImageView")
public class ImageView extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ImageView() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String num=request.getParameter("num");
		
		//1. upload 폴더에서 파일을 찾아 입력스트림을 생성한다.
		String path=request.getServletContext().getRealPath("upload");
		try {
		FileInputStream fis=new FileInputStream(new File(path,num));
		OutputStream out= response.getOutputStream();
		
		byte[] buff=new byte[4096];
		int len;
		
		while((len=fis.read(buff))>0) {
			out.write(buff,0,len);
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
