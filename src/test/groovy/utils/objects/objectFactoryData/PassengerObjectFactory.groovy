package utils.objects.objectFactoryData

import utils.helpers.RandomStringGenerator
import utils.objects.PassengerObject

public class PassengerObjectFactory {

    def static getPassengerData() {
        PassengerObject object = new PassengerObject();
        def randomFirstName = new RandomStringGenerator().getRandomString(16);
        def randomLastName = new RandomStringGenerator().getRandomString(32);
        object.title = "Pan";
        object.firstName = randomFirstName;
        object.lastName = randomLastName;
        return object;
    }



}
