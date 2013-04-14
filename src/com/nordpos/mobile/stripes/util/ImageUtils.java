/**
 *  Copyright (c) 2012 Nord Trading Ltd.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.nordpos.mobile.stripes.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;


/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 */
public class ImageUtils {

    public static byte[] createImageThumbnail(byte[] image, int size) throws IOException {

        InputStream in = new ByteArrayInputStream(image);
        BufferedImage thumbnail = ImageIO.read(in);

        thumbnail = Scalr.resize(thumbnail, Scalr.Method.SPEED, size);

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(thumbnail, "png", baos);
            baos.flush();
            image = baos.toByteArray();
        }

        return image;
    }

}
