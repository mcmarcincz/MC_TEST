package utils.objects.objectFactoryData

import utils.helpers.RandomStringGenerator
import utils.objects.PaymentCardObject

class PaymentCardObjectFactory {

def static PaymentCardObject object
    def static getPaymentCardObjectData() {
        if(object == null) {
            object = new PaymentCardObject();
            def randomFirstName = new RandomStringGenerator().getRandomString(16);
            def randomLastName = new RandomStringGenerator().getRandomString(32);
            def oneNumb3 = new Random().nextInt(1000);
            object.cardNumber = "5555 5555 5555 5557";
            object.cardType = "Visa";
            object.expiredMonth = "1";
            object.expiredYear = "2020";
            object.cvv = oneNumb3;
            object.cardHolder = randomLastName + " " + randomFirstName;
        }
        return object;
    }

}
