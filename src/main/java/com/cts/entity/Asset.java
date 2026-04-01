//package com.cts.entity;
//
//import java.time.Instant;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.Data;
//
//@Data
//@Entity
//@Table(name="Asset")
//public class Asset {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	
//	@Column(name = "AssetID")
//	private Long assetId;
//	
//	@Column(name = "AssetTag")
//	private String AssetTag;
//	
//	@Column(name = "AssetType")
//	private String Type;
//	
//	@Column(name = "Installation_Date")
//	private Instant InstallDate;
//	
//	@Column(name = "Asset_Location")
//	private String AssetLoc ;
//	
//	@Column(name = "Asset_Status")
//	private String assetStatus;
//	
//	
//}
