
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import com.mengxie.spring.controller.FileUploadController;

import static org.junit.Assert.*;

public class FileResourceTests {


	 
	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void should_upload_image_to_upload_path() throws Exception {
		MockMultipartFile file = new MockMultipartFile("file", "test.txt", MediaType.TEXT_PLAIN_VALUE,
				"test_context".getBytes());
		FileUploadController f=new FileUploadController();
		assertEquals( f.uploadFileHandler(file), "You successfully uploaded file and occurrences of all words of length 5 is 0"); 
		
	}
}
