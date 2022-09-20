package com.company.entity;

import com.google.gson.annotations.SerializedName;import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Photo{

	@SerializedName("albumId")
	private Integer albumId;

	@SerializedName("id")
	private Integer id;

	@SerializedName("title")
	private String title;

	@SerializedName("url")
	private String url;

	@SerializedName("thumbnailUrl")
	private String thumbnailUrl;
}