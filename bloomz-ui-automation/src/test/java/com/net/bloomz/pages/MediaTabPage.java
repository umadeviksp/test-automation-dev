package com.net.bloomz.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.net.bloomz.appium.pagefactory.framework.browser.Browser;
import com.net.bloomz.pages.android.AndroidMediaTabPage;
import com.net.bloomz.pages.interfaces.CreateMediaTabPageActions;
import com.net.bloomz.pages.web.WebCreateMediaTabPage;

public class MediaTabPage extends BasePage {

	static By photosMediaLocator = null;
	static By selectMediaLocator = null;
	static By albumsMediaLocator = null;
	static By createAlbumMediaLocator = null;
	static By albumTitleTextLocator = null;
	static By pickClassGroupLocator = null;
	static By selectClassLocator = null;
	static By doneClassLocator = null;
	static By createButtonLocator = null;
	static By successEventMessageLocator = null;
	static By addPhotoInputLocator = null;
	static By backButtonLocator = null;
	static By albumOptionsLocator = null;
	static By deleteAlbumLocator = null;
	static By photoLocator = null;
	static By optionsPhotoLocator = null;
	static By removePhotoLocator = null;
	static By photosTabPhotoLocator = null;
	static By photosTabDeletePhotoLocator = null;
	static By photosTabDownloadLocator = null;
	static By selectClassParentLocator = null;
	static By albumOptionsParentLocator = null;
	static By setAsAlbumCoverPhotoLocator = null;
	static By documentsMediaLocator = null;
	static By uploadDocumentsLinkLocator = null;
	static By uploadDocumentsTitleLocator = null;
	static By uploadDocumentsDescriptionLocator = null;
	static By attachFilesLocator = null;
	static By saveButtonLocator = null;
	static By uploadDocumentsDescriptionInput = null;
	static By udDesc;
	static By udDesc1;
	
	public MediaTabPage(Browser<?> browser) {
		super(browser);
	}

	public static MediaTabPage getMediaTabPage(Browser<?> browser) {
		String string = browser.toString();
		System.out.println(string);
		if (string.contains("AndroidMobile")) {
			photosMediaLocator = By.id("net.bloomz:id/llMainView");
			return new AndroidMediaTabPage(browser);
		} else if (string.contains(".iOS")) {
		} else {
			photosMediaLocator = By.xpath("//*[@id='media']/div[7]/div/section/h1/span[1]");
			selectMediaLocator = By.xpath("//*[@id='communityContent']/div/section/h1/a");
			albumsMediaLocator = By.xpath("//*[@id='media']/div[7]/div/section/h1/span[2]");
			createAlbumMediaLocator = By.xpath("//*[@id='media']//a[contains (text(),'Create Album')]");
			albumTitleTextLocator = By.xpath("//*[@id='contentDiv']//input[@name='AlbumTitle']");
			pickClassGroupLocator = By.xpath("//*[@id='contentDiv']//input[@placeholder='Pick Class/Group']");
			selectClassLocator = By.xpath("//*[@id='recipientPicker']//*[contains (text(),'Alpha Class')]");
			selectClassParentLocator = By.xpath("//*[@id='recipientPicker']//*[contains (text(),'dummy')]");
			doneClassLocator = By.xpath("//*[@id='recipientPicker']//*[@ng-if='showNextButton()']");
			createButtonLocator = By.xpath("//*[@id='contentDiv']//button[contains (text(),'Create')]");
			successEventMessageLocator = By.id("toast");
			addPhotoInputLocator = By.xpath("//*[@id='photoAlbumGallery']//*[contains (text(),'Add')]");
			backButtonLocator = By.xpath("//*[@id='photoAlbumGallery']//a[@ng-click = 'cancel()']");
			albumOptionsLocator = By.xpath("//*[@id='media']//div[1]//li[contains (text(),'Options')]");
			deleteAlbumLocator = By.xpath("//*[@id='actionSheet_optionsDiv']//span[contains (text(),'Delete Album')]");
			photoLocator = By.xpath("//*[@id='photoAlbumGallery']/div/div[2]/section/section/div/article/p[1]");
			photosTabPhotoLocator = By.xpath("//*[@id='media']/div[7]/div/section/div[1]/div/article/p");
			optionsPhotoLocator = By.xpath("//*[@id='bloomzSliderDiv']//a[contains (text(),'Options')]");
			removePhotoLocator = By.xpath("//*[@id='actionSheet_optionsDiv']//span[contains (text(),'Remove Photo from Album')]");
			setAsAlbumCoverPhotoLocator = By.xpath("//*[@id='actionSheet_optionsDiv']//span[contains (text(),'Set as Album Cover')]");
			photosTabDeletePhotoLocator = By.xpath("//*[@id='actionSheet_optionsDiv']//span[contains (text(),'Delete Photo Permanently')]");
			photosTabDownloadLocator = By.xpath("//*[@id='actionSheet_optionsDiv']//span[contains (text(),'Download')]");
			albumOptionsParentLocator = By.xpath("//*[@id='media']/div[7]/div/section/div[3]/article/footer/ul/li[2]");
			documentsMediaLocator = By.xpath("//*[@id='communityContent']//span[contains(text(),'Documents')]");
			uploadDocumentsLinkLocator = By.xpath("//*[@id='communityContent']//a[contains(text(),'Upload documents')]");
			uploadDocumentsTitleLocator = By.xpath("//*[@id='communityInfoCardEdit']//input[@placeholder='Title']");
			uploadDocumentsDescriptionLocator = By.xpath("//*[@id='communityInfoCardEdit']//div[contains(text(),'Please provide information you would like to share on Info page.')]");
			uploadDocumentsDescriptionInput = By.xpath("//*[@id=\"communityInfoCard_detail\"]");
			attachFilesLocator = By.xpath("//*[@id='communityInfoCardAddForm']//label[contains(text(),'Attach Files')]");
			saveButtonLocator = By.xpath("//*[@id='communityInfoCardEdit']//a[contains(text(),'Save')]");
			udDesc = By.xpath("//*[@id=\"communityInfoCardEdit\"]/div/div[1]/form/section[2]");
			udDesc1 = By.xpath("//*[@id=\"communityInfoCardEdit\"]/div/div[1]/form/section[2]/div[1]");
			return new WebCreateMediaTabPage(browser);
		}
		return null;
	}

	public MediaTabPage thenVerifyElementExists() {
		Assert.assertTrue(getElementSize(selectMediaLocator) > 0, "Media Tab is not displayed");
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage clickOnPhotosTab() {
		click(photosMediaLocator);	
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage clickOnAlbumsTab() {
		click(albumsMediaLocator);	
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage clickOnDocumentsTab() {
		click(documentsMediaLocator);	
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage clickOnCreateAlbumTab() throws InterruptedException {
		scrollIntoView(createAlbumMediaLocator);
		click(createAlbumMediaLocator);	
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage enterAlbumTitle(String sText) {
		sendText(albumTitleTextLocator,sText);	
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage clickOnPickClassGroup() {
		click(pickClassGroupLocator);	
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage selectClass() {
		click(selectClassLocator);	
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage clickOnDoneButton() {
		click(doneClassLocator);	
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage clickOnCreateButton() {
		click(createButtonLocator);	
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage thenVerifyThatEventWasSuccessful(String sText) {
		System.out.println(getText(successEventMessageLocator));
		Assert.assertEquals(getText(successEventMessageLocator), sText);
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage uploadImage(String pathToTestImage) throws InterruptedException, IOException {
		//browser.getWebDriver().findElement(addPhotoInputLocator).sendKeys(pathToTestImage);
		UploadFileAutoIT(pathToTestImage);
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage clickOnAddPhotoButton() {
		click(addPhotoInputLocator);	
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage clickOnBackButton() {
		click(backButtonLocator);	
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage clickOnAlbumOptions() {
		click(albumOptionsLocator);	
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage clickOnDeleteAlbum() {
		click(deleteAlbumLocator);	
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage clickOnPhoto() {
		click(photoLocator);	
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage clickOnOptionsPhoto() {
		click(optionsPhotoLocator);	
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage clickOnRemovePhoto() {
		click(removePhotoLocator);	
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage clickOnPhotosTabPhoto() {
		click(photosTabPhotoLocator);	
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage clickOnPhotosTabDeletePhoto() {
		click(photosTabDeletePhotoLocator);	
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage clickOnPhotosTabDownloadPhoto() {
		click(photosTabDownloadLocator);	
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage SelectClassParent() {
		click(selectClassParentLocator);	
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage clickOnAlbumOptionsParent() {
		click(albumOptionsParentLocator);	
		return MediaTabPage.getMediaTabPage(browser);
	}
		
	public MediaTabPage clickOnSetAsAlbumCover() {
		click(setAsAlbumCoverPhotoLocator);	
		return MediaTabPage.getMediaTabPage(browser);
	}
		
	public MediaTabPage clickOnUploadDocuments() {
		click(uploadDocumentsLinkLocator);	
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage enterTitleUploadDocuments(String sTitle) {
		sendText(uploadDocumentsTitleLocator,sTitle);	
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage enterDescriptionUploadDocuments(String sDescription) {
		//click(uploadDocumentsDescriptionLocator);
		//sendkeyboardEvent(uploadDocumentsDescriptionLocator);
		//udDesc
		select(uploadDocumentsDescriptionLocator);
		//sendkeyboardEvent(udDesc1);
		sendText(uploadDocumentsDescriptionInput,sDescription);	
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage clickOnAttachFiles() {
		click(attachFilesLocator);	
		return MediaTabPage.getMediaTabPage(browser);
	}
	/*
	public MediaTabPage uploadFile(String pathToTestImage) {
		browser.getWebDriver().findElement(attachFilesLocator).sendKeys(pathToTestImage);
		return MediaTabPage.getMediaTabPage(browser);
	}*/
	
	public MediaTabPage uploadFile(String pathToTestImage) throws InterruptedException, IOException {
		//browser.getWebDriver().findElement(uploadNewPhotoButtonLocator).sendKeys(pathToTestImage);
		//return CreatePostInClassPage.getCreatePostInClassPage(browser);

		UploadFileAutoIT(pathToTestImage);
		return MediaTabPage.getMediaTabPage(browser);
	}
	
	public MediaTabPage clickOnSave() {
		click(saveButtonLocator);	
		return MediaTabPage.getMediaTabPage(browser);
	}
	
}
