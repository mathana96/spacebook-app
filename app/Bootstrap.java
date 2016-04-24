import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import play.*;
import play.db.jpa.Blob;
import play.jobs.*;
import play.libs.MimeTypes;
import play.test.*;

import models.*;

@OnApplicationStart
public class Bootstrap extends Job 
{ 
	public void doJob() throws FileNotFoundException
	{
		if (User.count() == 0)
		{
			Fixtures.deleteDatabase();
			Fixtures.loadModels("data.yml");  

			String photoName = "public/images/homer.gif";
			Blob blob = new Blob ();
			blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
			User homer = User.findByEmail("homer@simpson.com");
			homer.profilePicture = blob;
			homer.save();

			photoName = "public/images/t_homer.jpg";
			blob = new Blob ();
			blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
			homer = User.findByEmail("homer@simpson.com");
			homer.thumbnailPicture = blob;
			homer.save();

			photoName = "public/images/marge.gif";
			blob = new Blob ();
			blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
			User marge = User.findByEmail("marge@simpson.com");
			marge.profilePicture = blob;
			marge.save();

			photoName = "public/images/t_marge.jpg";
			blob = new Blob ();
			blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
			marge = User.findByEmail("marge@simpson.com");
			marge.thumbnailPicture = blob;
			marge.save();

			photoName = "public/images/lisa.gif";
			blob = new Blob ();
			blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
			User lisa = User.findByEmail("lisa@simpson.com");
			lisa.profilePicture = blob;
			lisa.save();

			photoName = "public/images/t_lisa.gif";
			blob = new Blob ();
			blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
			lisa = User.findByEmail("lisa@simpson.com");
			lisa.thumbnailPicture = blob;
			lisa.save();

			photoName = "public/images/bart.gif";
			blob = new Blob ();
			blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
			User bart = User.findByEmail("bart@simpson.com");
			bart.profilePicture = blob;
			bart.save();

			photoName = "public/images/t_bart.jpg";
			blob = new Blob ();
			blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
			bart = User.findByEmail("bart@simpson.com");
			bart.thumbnailPicture = blob;
			bart.save();

			photoName = "public/images/maggie.gif";
			blob = new Blob ();
			blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
			User maggie = User.findByEmail("maggie@simpson.com");
			maggie.profilePicture = blob;
			maggie.save();

			photoName = "public/images/t_maggie.jpg";
			blob = new Blob ();
			blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
			maggie = User.findByEmail("maggie@simpson.com");
			maggie.thumbnailPicture = blob;
			maggie.save();

			photoName = "public/images/krusty.gif";
			blob = new Blob ();
			blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
			User krusty = User.findByEmail("krusty@simpson.com");
			krusty.profilePicture = blob;
			krusty.save();

			photoName = "public/images/t_krusty.jpg";
			blob = new Blob ();
			blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
			krusty = User.findByEmail("krusty@simpson.com");
			krusty.thumbnailPicture = blob;
			krusty.save();

			photoName = "public/images/charles.jpg";
			blob = new Blob ();
			blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
			User charles = User.findByEmail("charles@simpson.com");
			charles.profilePicture = blob;
			charles.save();

			photoName = "public/images/t_charles.gif";
			blob = new Blob ();
			blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
			charles = User.findByEmail("charles@simpson.com");
			charles.thumbnailPicture = blob;
			charles.save();

			photoName = "public/images/apu.gif";
			blob = new Blob ();
			blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
			User apu = User.findByEmail("apu@simpson.com");
			apu.profilePicture = blob;
			apu.save();

			photoName = "public/images/apu.gif";
			blob = new Blob ();
			blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
			apu = User.findByEmail("apu@simpson.com");
			apu.thumbnailPicture = blob;
			apu.save();

			photoName = "public/images/moe.gif";
			blob = new Blob ();
			blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
			User moe = User.findByEmail("moe@simpson.com");
			moe.profilePicture = blob;
			moe.save();

			photoName = "public/images/moe.gif";
			blob = new Blob ();
			blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
			moe = User.findByEmail("moe@simpson.com");
			moe.thumbnailPicture = blob;
			moe.save();

			photoName = "public/images/millhouse.gif";
			blob = new Blob ();
			blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
			User millhouse = User.findByEmail("millhouse@simpson.com");
			millhouse.profilePicture = blob;
			millhouse.save();

			photoName = "public/images/t_millhouse.jpg";
			blob = new Blob ();
			blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
			millhouse = User.findByEmail("millhouse@simpson.com");
			millhouse.thumbnailPicture = blob;
			millhouse.save();

			photoName = "public/images/grampa.png";
			blob = new Blob ();
			blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
			User grampa = User.findByEmail("grampa@simpson.com");
			grampa.profilePicture = blob;
			grampa.save();

			photoName = "public/images/t_grampa.gif";
			blob = new Blob ();
			blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
			grampa = User.findByEmail("grampa@simpson.com");
			grampa.thumbnailPicture = blob;
			grampa.save();

			photoName = "public/images/mona.png";
			blob = new Blob ();
			blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
			User mona = User.findByEmail("mona@simpson.com");
			mona.profilePicture = blob;
			mona.save();

			photoName = "public/images/t_mona.jpg";
			blob = new Blob ();
			blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
			mona = User.findByEmail("mona@simpson.com");
			mona.thumbnailPicture = blob;
			mona.save();
		}




	}
}