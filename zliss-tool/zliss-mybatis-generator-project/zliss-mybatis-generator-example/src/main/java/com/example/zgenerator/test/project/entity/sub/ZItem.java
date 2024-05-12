package com.example.zgenerator.test.project.entity.sub;

public class ZItem {

    private Long id; // DatabaseType:BIGINT UNSIGNED, DatabaseDefault:null, DatabaseRemark:id
    private String type; // DatabaseType:VARCHAR, DatabaseDefault:"", DatabaseRemark:type
    private String url; // DatabaseType:VARCHAR, DatabaseDefault:"", DatabaseRemark:url
    private Integer status; // DatabaseType:TINYINT, DatabaseDefault:0, DatabaseRemark:status

    public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return this.id;
	}

    public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return this.type;
	}

    public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return this.url;
	}

    public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}

}