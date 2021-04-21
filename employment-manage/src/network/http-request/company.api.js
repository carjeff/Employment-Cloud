import axios from 'axios'

const company = {
    //通过主键id查找企业
    selectCompanyById(id) {
        return axios.get(`admin/company`, id)
    },
    //添加企业
    addCompany(data) {
        return axios.post(`admin/company`, data)
    },
    //查询所有企业
    getAllCompanies() {
        return axios.get(`admin/companies`)
    },
    //删除对应id企业
    deleteCompany(id) {
        return axios.delete(`admin/company`, id)
    },
    //更新企业
    updateCompany(data) {
        return axios.put(`admin/company`, data)
    },
    //根据企业名模糊查找
    getCompanyByName(param) {
        return axios.get(`admin/company/name`, param)
    },
    //根据地点查找企业
    getCompanyByCity(param) {
        return axios.get(`admin/company/city`, param)
    },
    //根据企业性质找企业
    getCompanyByNature(param) {
        return axios.get(`admin/company/nature`, param)
    }
}

export default company