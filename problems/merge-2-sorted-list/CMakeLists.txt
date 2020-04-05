project("Merge 2 Sorted List")

add_executable(
    test
    main.cc
    solution.cc)

target_include_directories(
    test
    PUBLIC
      .)

target_compile_features(
    test
    PUBLIC
      cxx_std_14)

