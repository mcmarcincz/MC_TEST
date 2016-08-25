package utils.helpers


class RandomStringGenerator {

    def random = new Random(new Date().getTime() as int)


    def getRandomString(int size) {
        def builder = new StringBuilder()
        1.upto(size, {
            def ch = ((Math.floor(26 * random.nextDouble() + 65))) as char
            ch = Character.toLowerCase(ch)
            if (it % 3 == 0) ch = Character.toUpperCase(ch)
            builder.append(ch)
        })

        builder.toString()
    }
}
