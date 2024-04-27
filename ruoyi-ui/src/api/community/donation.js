import request from '@/utils/request'

// 查询捐赠管理列表
export function listDonation(query) {
  return request({
    url: '/community/donation/list',
    method: 'get',
    params: query
  })
}

// 查询捐赠管理详细
export function getDonation(donationId) {
  return request({
    url: '/community/donation/' + donationId,
    method: 'get'
  })
}

// 新增捐赠管理
export function addDonation(data) {
  return request({
    url: '/community/donation',
    method: 'post',
    data: data
  })
}

// 修改捐赠管理
export function updateDonation(data) {
  return request({
    url: '/community/donation',
    method: 'put',
    data: data
  })
}

// 删除捐赠管理
export function delDonation(donationId) {
  return request({
    url: '/community/donation/' + donationId,
    method: 'delete'
  })
}
