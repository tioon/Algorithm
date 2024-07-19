SELECT COUNT(*) AS COUNT
FROM ecoli_data
WHERE (genotype&2 = 0)
    AND (genotype&1!=0 OR genotype&4 != 0)