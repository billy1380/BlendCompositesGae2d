//
//  Program.java
//  BlendComposites
//
//  Created by William Shakour (billy1380) on 13 Sep 2013.
//  Copyright © 2013 SPACEHOPPER STUDIOS LTD. All rights reserved.
//	All rights reserved.
//	
//	Redistribution and use in source and binary forms, with or without modification,
//	are permitted provided that the following conditions are met:
//	
//	  Redistributions of source code must retain the above copyright notice, this
//	  list of conditions and the following disclaimer.
//	
//	  Redistributions in binary form must reproduce the above copyright notice, this
//	  list of conditions and the following disclaimer in the documentation and/or
//	  other materials provided with the distribution.
//	
//	THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
//	ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
//	WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
//	DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
//	ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
//	(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
//	LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
//	ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
//	(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
//	SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
package composite.desktop;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.sanselan.ImageFormat;
import org.apache.sanselan.ImageWriteException;
import org.apache.sanselan.Sanselan;

import com.jgraph.gaeawt.java.awt.Graphics2D;
import com.jgraph.gaeawt.java.awt.image.BufferedImage;

import composite.BlendComposite;
import composite.GraphicsUtil;

/**
 * @author billy1380
 * 
 */
public class Program {

	/**
	 * @param args
	 * @throws IOException
	 * @throws ImageWriteException
	 */
	public static void main(String[] args) throws IOException, ImageWriteException {
		BufferedImage imageA = GraphicsUtil.loadCompatibleImage(Program.class.getResource("/composite/images/A.png"));
		BufferedImage imageB = GraphicsUtil.loadCompatibleImage(Program.class.getResource("/composite/images/B.png"));
		BufferedImage image = new BufferedImage(imageA.getWidth(), imageA.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = image.createGraphics();
		g2.drawImage(imageA, 0, 0, null);
		g2.setComposite(BlendComposite.ColorBurn);
		g2.drawImage(imageB, 0, 0, null);
		g2.dispose();
		OutputStream out = new FileOutputStream("image.png");
		Sanselan.writeImage(image, out, ImageFormat.IMAGE_FORMAT_PNG, null);

	}

}
