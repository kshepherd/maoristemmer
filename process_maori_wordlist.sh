#!/bin/bash

if [ $# -lt 1 ]; then
    echo "Usage: $0 <input_file> [output_file]"
    echo "If output_file is not specified, results are printed to stdout"
    exit 1
fi

input_file="$1"
output_file="$2"

if [ ! -f "$input_file" ]; then
    echo "Error: File '$input_file' not found."
    exit 1
fi

process_words() {
    # lowercase, remove non-alpha, space, hyphen
    # (preserving macrons and diaereses) chars
    # split words on whitespace, sort and deduplicate
    cat "$input_file" | \
    tr '[:upper:]' '[:lower:]' | \
    sed 's/[^a-zA-Z0-9āēīōūäëïöü \t\n-]//g' | \
    tr -s '[:space:]' '\n' | \
    grep -v '^$' | \
    sort -u
}

if [ -n "$output_file" ]; then
    process_words > "$output_file"
    word_count=$(wc -l < "$output_file")
    echo "Processed $word_count unique words to '$output_file'"
else
    process_words
fi
