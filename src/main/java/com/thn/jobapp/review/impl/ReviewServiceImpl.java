package com.thn.jobapp.review.impl;

import com.thn.jobapp.company.Company;
import com.thn.jobapp.company.CompanyService;
import com.thn.jobapp.review.Review;
import com.thn.jobapp.review.ReviewRepository;
import com.thn.jobapp.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if(company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }

        return false;

    }

}
