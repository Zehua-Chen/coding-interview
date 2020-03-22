project("Regular Expression Matching")

add_executable(
    test
    main.cc
    solution.cc)

target_include_directories(
    test
    PUBLIC
      .)

set_target_properties(
    test
    PROPERTIES
      cxx_standard 14)
