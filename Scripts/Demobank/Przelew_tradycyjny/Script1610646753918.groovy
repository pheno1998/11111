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

String msg_error_demobank = WebUI.getText(findTestObject('Demobank_logowanie/error_logowania'))
assert msg_error_expected == msg_error_demobank

WebUI.setText(findTestObject('Demobank_logowanie/button_demobank'),
	findTestData('Demobank/Dane_logowania').getValue('login', 1))

WebUI.click(findTestObject('Demobank_logowanie/login_label'))

WebUI.setText(findTestObject('Demobank_logowanie/button_demobank'),
	findTestData('Demobank/Dane_logowania').getValue('login', 2))

WebUI.click(findTestObject('Demobank_logowanie/button_dalej'))

WebUI.setText(findTestObject('Demobank_logowanie/input_password'), GlobalVariable.password)

WebUI.click(findTestObject('Demobank_logowanie/button_dalej'))

WebUI.click(findTestObject('Demobank_zalogowany/a_platnosci'))

for (def row = 1; row <= findTestData('Demobank/Dane_do_przelewu').getRowNumbers(); row++)
{

	WebUI.setText(findTestObject('Demobank_przelew/input_name'),
		 findTestData('Demobank/Dane_do_przelewu').getValue('name', 1))
	
	WebUI.setText(findTestObject('Demobank_przelew/account_number_input'),
		findTestData('Demobank/Dane_do_przelewu').getValue('account_number', 1))
	
	WebUI.setText(findTestObject('Demobank_przelew/input_amount'),
		findTestData('Demobank/Dane_do_przelewu').getValue('amount', 1))
	
	WebUI.setText(findTestObject('Demobank_przelew/input_title'),
		findTestData('Demobank/Dane_do_przelewu').getValue('title', 1))
	
	WebUI.click(findTestObject('Demobank_przelew/input_checkbox'))
	
	WebUI.setText(findTestObject('Demobank_przelew/input_email'),
		findTestData('Demobank/Dane_do_przelewu').getValue('email', 1))
	
	WebUI.click(findTestObject('Demobank_przelew/button_dalej'))
}
WebUI.click(findTestObject('Demobank_zalogowany/a_pulpit'))

String amount = WebUI.getText(findTestObject('Demobank_zalogowany/amount_money'))
assert available_money == amount


WebUI.closeBrowser()