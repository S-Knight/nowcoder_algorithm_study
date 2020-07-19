<?php


class Solution
{
    private $string1 = "";

    private $string2 = "";

    public function __construct()
    {
        $this->getInput();
    }

    private function getInput()
    {
        if (fscanf(STDIN, "%[^\n]s", $this->string1) == 1) {
            fscanf(STDIN, "%[^\n]s", $this->string2);
        }
    }

    public function getLongestCommonStrLength()
    {
        $longestCommonStrLength = 0;

        $string1Length = strlen($this->string1);
        for ($i = 0; $i < $string1Length; $i++) {
            for ($length = 1; $length <= $string1Length - $i; $length++) {
                $substr = substr($this->string1, $i, $length);

                if (strstr($this->string2, $substr) !== false) {
                    if ($length > $longestCommonStrLength) {
                        $longestCommonStrLength = $length;
                    }
                } else {
                    break;
                }
            }
        }

        return $longestCommonStrLength;
    }
}

$solution = new Solution();
echo $solution->getLongestCommonStrLength() . "\n";