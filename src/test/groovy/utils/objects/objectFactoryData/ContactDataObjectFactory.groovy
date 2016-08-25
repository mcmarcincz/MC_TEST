package utils.objects.objectFactoryData

import utils.helpers.RandomStringGenerator
import utils.objects.ContactDataObject


class ContactDataObjectFactory {

    def static ContactDataObject object

    def static getContactData() {
        if(object == null) {
            object = new ContactDataObject();
            def random16 = new RandomStringGenerator().getRandomString(16);
            def random4 = new RandomStringGenerator().getRandomString(4);
            def random2 = new RandomStringGenerator().getRandomString(2);
            def randomNumber = new Random().nextInt(1000000 - 1);
            object.email = random16 + "@" + random4 + "." + random2;
            object.country = "Polska";
            object.phoneNumber = randomNumber;
        }
        return object;
    }






}
