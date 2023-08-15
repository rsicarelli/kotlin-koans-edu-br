package referencias

import (
	"strings"
)

func joinOptions(options []string) string {
	return "[" + strings.Join(options, ", ") + "]"
}
