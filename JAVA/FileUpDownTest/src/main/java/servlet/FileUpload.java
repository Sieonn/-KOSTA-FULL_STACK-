package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/fileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("fileUploadForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadpath = request.getServletContext().getRealPath("doc");
		int size = 10*1024*1024;
		
		MultipartRequest multi =  new MultipartRequest(request, uploadpath,size,"utf-8",new DefaultFileRenamePolicy());
		
		String name=multi.getParameter("name");
		String title=multi.getParameter("title");
		String file1Name=multi.getOriginalFileName("file1");
		String file2Name=multi.getOriginalFileName("file2");
		
		request.setAttribute("name", name);
		request.setAttribute("title", title);
		request.setAttribute("file1", file1Name);
		request.setAttribute("file2", file2Name);
		
		request.getRequestDispatcher("fileUploadResult.jsp").forward(request, response);
	}

}
