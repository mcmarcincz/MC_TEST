package utils.objects.objectFactoryData

import utils.helpers.RandomStringGenerator
import utils.objects.BillingAddressObject


class BillingAddressObjectFactory {
        def static BillingAddressObject object
        def static getBillingAddressObjectData() {
        if(object == null) {
            object = new BillingAddressObject();
            def randomLine1 = new RandomStringGenerator().getRandomString(16);
            def randomLine2 = new RandomStringGenerator().getRandomString(32);
            def randomCity = new RandomStringGenerator().getRandomString(32);
            def oneNumb2 = new Random().nextInt(100);
            def oneNumb3 = new Random().nextInt(1000);
            object.line1 = randomLine1;
            object.line2 = randomLine2;
            object.city = randomCity;
            object.zipCode = oneNumb2+"-"+oneNumb3;
            object.country = "Polska";
        }
        return object;
    }

}
