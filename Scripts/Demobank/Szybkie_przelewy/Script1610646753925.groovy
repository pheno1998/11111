import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
/*
 * Uruchomienie przegladarki i uruchomienie strony ze zmiennej url_elearning
 */
WebUI.openBrowser(rawUrl=GlobalVariable.url)
/*
 * Zmiana wielkosci okna
 */
WebUI.maximizeWindow()
/*
 * Klikniecie na obiekt link - obiekt a_Zaloguj si
 */
WebUI.click(findTestObject('Demobank_logowanie/button_demobank'))
/*
 * Dostęp do danych testowych
 */
WebUI.click(findTestObject('Demobank_logowanie/login_label'))

WebUI.setText(findTestObject('Demobank_logowanie/button_demobank'),
	findTestData('Demobank/Dane_logowania').getValue('login', 1))

WebUI.click(findTestObject('Demobank_logowanie/login_label'))

WebUI.setText(findTestObject('Demobank_logowanie/button_demobank'),
	findTestData('Demobank/Dane_logowania').getValue('login', 2))

WebUI.click(findTestObject('Demobank_logowanie/button_dalej'))

WebUI.setText(findTestObject('Demobank_logowanie/input_password'), GlobalVariable.password)

WebUI.click(findTestObject('Demobank_logowanie/button_dalej'))

WebUI.click(findTestObject('Demobank_szybkie_przelewy/input_select'))

WebUI.click(findTestObject('Demobank_szybkie_przelewy/select_option'))

String amount = WebUI.getText(findTestObject('Demobank_zalogowany/amount_money'))
assert available_money == amount

//WebUI.closeBrowser()