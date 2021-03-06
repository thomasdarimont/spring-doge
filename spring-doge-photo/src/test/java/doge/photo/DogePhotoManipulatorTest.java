package doge.photo;

import java.io.File;
import java.io.FileOutputStream;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import doge.photo.DogePhotoManipulator;
import doge.photo.Photo;
import doge.photo.PhotoManipulator;

/**
 * Tests for {@link DogePhotoManipulator}.
 *
 * @author Phillip Webb
 * @author Josh Long
 */
public class DogePhotoManipulatorTest {

	private PhotoManipulator manipulator = new DogePhotoManipulator();

	private File file;

	@Before
	public void clean() {
		File target = new File(System.getProperty("java.io.tmpdir"));
		this.file = new File(target, "manipulatedhoff.jpg");
		this.file.delete();
		System.out.println(this.file);
	}

	@Test
	public void testDogePhotoManipulatorService() throws Exception {
		Photo photo = () -> new ClassPathResource("thehoff.jpg").getInputStream();
		Photo manipulated = this.manipulator.manipulate(photo);
		FileCopyUtils.copy(manipulated.getInputStream(), new FileOutputStream(this.file));
	}
}
