package referencias

func containsEven(collection []int) bool {
	for _, item := range collection {
		if item%2 == 0 {
			return true
		}
	}
	return false
}
