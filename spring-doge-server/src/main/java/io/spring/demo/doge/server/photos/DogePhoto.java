/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.spring.demo.doge.server.photos;

import io.spring.demo.doge.server.users.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;

import java.math.BigInteger;

/**
 * A DogePhoto submitted by a {@link io.spring.demo.doge.server.users.User}.
 *
 * @author Phillip Webb
 * @author Josh Long
 */
public class DogePhoto {

    @Id
    private BigInteger id;
    @DBRef
    private User user;
    private String title;
    private String mediaType;

    public DogePhoto(User user, String mediaType, String title) {
        Assert.notNull(user);
        Assert.hasText(mediaType);
        this.user = user;
        this.mediaType = MediaType.parseMediaType(mediaType).toString();
        this.title = title;
    }

    public String getMediaType() {
        return mediaType;
    }

    public User getUser() {
        return this.user;
    }

    public String getTitle() {
        return this.title;
    }

    public BigInteger getId() {
        return this.id;
    }
}