class Day3 {

    fun getDuplicateItem(input: String): MutableList<Char> {
        val duplicateItems = mutableListOf<Char>()
        val split = input.split("\n")

        split.forEachIndexed rucksackLoop@{ i,rucksack ->
            val firstLine = rucksack.split("\n")[i]
            val secondLine = rucksack.split("\n")[i+1]
            val thirdLine = rucksack.split("\n")[i+2]
            println(firstLine)
            firstLine.forEach { fChar ->
                for (sChar in secondLine) {
                    for(tChar in thirdLine) {
                        if (fChar == sChar && fChar == tChar) {
                            duplicateItems.add(fChar)
                            return@rucksackLoop
                        }
                    }
                }
            }
            if(i+3 == split.size) {
                return duplicateItems

            }
//            frontCompartment.forEach { frontChar ->
//                for (backChar in backCompartment) {
//                    if (backChar == frontChar) {
//                        duplicateItems.add(frontChar)
//                        return@rucksackLoop
//                    }
//                }
//            }
        }
        return duplicateItems
    }

    fun calculatePriorities(input: String): Int {
        val items = getDuplicateItem(input)
        var prioritySum = 0
        items.forEach { item ->
            val ascii = item.toInt()
            if (item.isUpperCase()) {
                prioritySum += (ascii - 38)
            } else {
                prioritySum += (ascii- 96)
            }
        }
        return prioritySum
    }
}