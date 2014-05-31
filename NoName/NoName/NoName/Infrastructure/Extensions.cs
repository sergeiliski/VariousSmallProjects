using System;
using System.Linq;

namespace NoName.Infrastructure {
    public static class Extensions {
        /* Shortens a string to approximately (and maximally) the given length */
        public static string Truncate(this String input, int length) {
            if (input.Length <= length) {
                return input;
            }

            var shard = (length * 75 / 100);
            for (var i = length; i > shard; i--) {
                var sub = input.Substring(i, 1);
                if (".?!".Contains(sub)) {
                    return input.Substring(0, i);
                }
            }

            return input.Substring(0, length - 3) + "...";
        }

        /* Returns a string suited for URL usage in web requests */
        public static string ToURL(this String input) {
            var text = input.Trim().ToLower().ToArray();
            var result = "";

            foreach (var letter in text) {
                if ((letter < 97 || letter > 122) && (letter < 48 || letter > 57)) {
                    if (!result.EndsWith("%20")) {
                        result += "%20";
                    }
                } else {
                    result += letter;
                }
            }

            if (result.EndsWith("%20")) {
                result = result.Substring(0, result.Length - 3);
            }

            if (result.EndsWith("%20the")) {
                result = "the%20" + result.Substring(0, result.Length - 6);
            }

            return result.Trim();
        }
    }
}