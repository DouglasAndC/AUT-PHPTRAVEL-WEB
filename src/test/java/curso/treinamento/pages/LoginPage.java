package curso.treinamento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import curso.treinamento.utils.Helper;

public class LoginPage {
	
	public LoginPage(WebDriver driver) { 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "email")
	private WebElement campoEmail;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement campoPassword;
	
	@FindBy(xpath = "//span[text()='Login']")
	private WebElement botaoLogin;
	
	@FindBy(xpath = "//span[text()='Remove Frame']")
	private WebElement botaoRemoverFram;
	
	@FindBy(xpath = "//p[contains(text(), 'The Email field must contain a valid email address.')]")
	private WebElement txtLoginInvalido;
	
	public void preencher_email(String email) { 
		campoEmail.sendKeys(email);
	}
	
	public void preencher_password(String password) {
		campoPassword.sendKeys(password);
	}
	
	public void clicar_botao_login() {
		botaoLogin.click();
	}
	
	public Boolean validar_pagina() { 
		Helper.elemento_existe(botaoLogin, 50);
		return botaoLogin.isDisplayed();
	}
	
	public void clicar_remover_frame() {
		if(Helper.elemento_existe(botaoRemoverFram, 10)){
			botaoRemoverFram.click();
		}
	}
	
	public boolean validar_login_falha() {
		
		return	Helper.elemento_existe(txtLoginInvalido, 10);
		
	}

}
